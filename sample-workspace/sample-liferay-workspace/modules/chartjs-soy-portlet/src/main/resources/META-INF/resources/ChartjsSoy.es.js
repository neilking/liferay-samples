import Component from 'metal-component/src/Component';
import core from 'metal/src/core';
import dom from 'metal-dom/src/dom';
import Soy from 'metal-soy/src/Soy';
import Chart from 'chartjs-soy/js/Chart';
import templates from './ChartjsSoy.soy';

class ChartjsSoy extends Component {

	constructor(opt_config) {
		super(opt_config);

		this.createChart_();

	}

	/**
	 * Create Chart
	 *
	 * @protected
	 */
	createChart_() {
		let chartcanvas = document.getElementById("chartjs-soy");

		let data = {
			labels: ["January", "February", "March", "April", "May", "June", "July"],
			datasets: [
				{
					label: "My First dataset",
					backgroundColor: [
						'rgba(255, 99, 132, 0.2)',
						'rgba(54, 162, 235, 0.2)',
						'rgba(255, 206, 86, 0.2)',
						'rgba(75, 192, 192, 0.2)',
						'rgba(153, 102, 255, 0.2)',
						'rgba(255, 159, 64, 0.2)'
					],
					borderColor: [
						'rgba(255,99,132,1)',
						'rgba(54, 162, 235, 1)',
						'rgba(255, 206, 86, 1)',
						'rgba(75, 192, 192, 1)',
						'rgba(153, 102, 255, 1)',
						'rgba(255, 159, 64, 1)'
					],
					borderWidth: 1,
					data: [65, 59, 80, 81, 56, 55, 40],
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
			data: data,
			options: options
		});

	}

}

//Register component
Soy.register(ChartjsSoy, templates);

export default ChartjsSoy;
