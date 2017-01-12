import Component from 'metal-component/src/Component';
import core from 'metal/src/core';
import dom from 'metal-dom/src/dom';
import Soy from 'metal-soy/src/Soy';
import templates from './ChartjsSoy.soy';

class ChartjsSoy extends Component {

}

//Register component
Soy.register(ChartjsSoy, templates);

export default ChartjsSoy;
