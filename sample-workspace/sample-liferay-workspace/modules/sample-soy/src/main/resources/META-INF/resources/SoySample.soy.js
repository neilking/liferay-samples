// This file was automatically generated from SoySample.soy.
// Please don't edit this file by hand.

/**
 * @fileoverview Templates in namespace SoySample.
 * @public
 */

if (typeof SoySample == 'undefined') { var SoySample = {}; }


SoySample.render = function(opt_data, opt_ignored) {
  return soydata.VERY_UNSAFE.ordainSanitizedHtml('<div id="' + soy.$$escapeHtmlAttribute(opt_data.id) + '"><div class="form-group"><div class="input-group"><span class="input-group-addon" id="inputGroupAddon01">Message:</span><input aria-describedby="inputGroupAddon01" class="form-control" value="' + soy.$$escapeHtmlAttribute(opt_data.msg) + '" type="text"></div></div><div class="form-group"><div class="input-group"><input aria-describedby="inputGroupAddon02" class="form-control" placeholder="Recipient\'s username, ex. neil.jin ;)" type="text"><span class="input-group-addon" id="inputGroupAddon02">@liferay.com</span></div></div><div class="form-group"><div class="input-group"><span class="input-group-addon">$</span><input aria-label="Amount" class="form-control" type="text"><span class="input-group-addon">.00</span></div></div><div class="form-group"><button class="btn btn-default" data-onclick="donate" type="button">Donate</button></div></div>');
};
if (goog.DEBUG) {
  SoySample.render.soyTemplateName = 'SoySample.render';
}
