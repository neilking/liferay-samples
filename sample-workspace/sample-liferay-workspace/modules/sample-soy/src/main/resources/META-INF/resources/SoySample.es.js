import Component from 'metal-component/src/Component';
import core from 'metal/src/core';
import dom from 'metal-dom/src/dom';
import Soy from 'metal-soy/src/Soy';
import templates from './SoySample.soy';

class SoySample extends Component {
	/**
	 * donate to neil
	 *
	 * @param  {MouseEvent} event
	 */
	donate(event) {
		console.log("donate successful");
	 }
}

//Register component
Soy.register(SoySample, templates);

export default SoySample;
