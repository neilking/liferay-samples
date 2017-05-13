import Component from 'metal-component/src/Component';
import core from 'metal/src/core';
import dom from 'metal-dom/src/dom';
import Soy from 'metal-soy/src/Soy';
import { CancellablePromise } from 'metal-promise/src/promise/Promise';
import Chart from 'monthly-trading/js/Chart';
import templates from './MonthlyTrading.soy';

class MonthlyTrading extends Component {
	constructor(opt_config) {

		super(opt_config);

		let remoteURL = opt_config.remoteURL;
		let tradingYear = opt_config.tradingYear;
		this.portletNamespace = opt_config.portletNamespace;
		this.createRemoteChart_(remoteURL, tradingYear);
	}

	/**
	 * Create Chart with data url
	 *
	 * @param {String} remoteURL
	 * @protected
	 */
	createRemoteChart_(remoteURL, tradingYear) {
		this.getChartData_(remoteURL).then(data => {

			let chartcanvas = document.getElementById(this.portletNamespace + "monthly-trading-chart");

			let labels = Array.from(data, d => d.month);
			let bgColor = this.getPreferedColors_(data.length, 0.3);
			let borderColor = this.getPreferedColors_(data.length, 0.8);
			let dataValue = Array.from(data, d => d.volume);

			let chartData = {
				labels: labels,
				datasets: [
					{
						label: "Monthly Trade of " + tradingYear,
						backgroundColor: bgColor,
						borderColor: borderColor,
						borderWidth: 1,
						data: dataValue,
					}
				]
			};

			let options = {
				scales: {
					xAxes: [{
						stacked: true
					}],
					yAxes: [{
						stacked: true
					}]
				}
			};

			let myBarChart = new Chart(chartcanvas, {
				type: 'bar',
				data: chartData,
				options: options
			});
		});

	}

	/**
	 * Get remote trading data
	 * @protected
	 * @param  {String} remoetURL
	 * @return {CancellablePromise} A promise that will resolve save permise
	 */
	getChartData_(remoteURL) {
		let promise = new CancellablePromise((resolve, reject) => {
			let requestConfig = {
				contentType: false,
				dataType: "json",
				processData: false,
				type: "GET",
				url: remoteURL
			};

			AUI.$.ajax(requestConfig)
				.done((data) => resolve(data))
				.fail((jqXHF, status, error) => reject(error));
		});

		return promise;
	}

	/**
	 * Get Bar backgroud colors from prefered colors
	 * @protected
	 * @param {int} length
	 * @param {string} opacity
	 * @return {Array} a color array
	 */
	getPreferedColors_(length, opacity=1) {

		let colorsRepo = [
			"255, 99, 132",
			"54, 162, 235",
			"255, 206, 86",
			"75, 192, 192",
			"153, 102, 255",
			"255, 159, 64"
		];

		let colors = new Array();

		for (let i = 0; i < length; i++) {
			let index = i % colorsRepo.length ;
			let color = "rgba(" + colorsRepo[index] + "," + opacity + ")";
			colors.push(color)
		}

		return colors;
	}
}

Soy.register(MonthlyTrading, templates);

/**
 * State definition.
 * @type {!Object}
 * @static
 */
MonthlyTrading.STATE = {
};

export default MonthlyTrading;
