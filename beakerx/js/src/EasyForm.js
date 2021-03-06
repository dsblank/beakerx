/*
 *  Copyright 2017 TWO SIGMA OPEN SOURCE, LLC
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

var widgets = require('jupyter-js-widgets');
var _ = require('underscore');

var buttonWidget = require('./easyForm/buttonWidget');
var selectMultipleWidget = require('./easyForm/selectMultipleWidget');
var selectMultipleSingleWidget = require('./easyForm/selectMultipleSingleWidget');

require('./easyForm/css/jupyter-easyform.scss');

var EasyFormModel = widgets.DOMWidgetModel.extend({
  defaults: _.extend({}, widgets.DOMWidgetModel.prototype.defaults, {
    _model_name : 'EasyFormModel',
    _view_name : 'EasyFormView',
    _model_module : 'beakerx',
    _view_module : 'beakerx',
    children: []
  }),
}, {
  serializers: _.extend({
    children: {deserialize: widgets.unpack_models},
  }, widgets.DOMWidgetModel.serializers)
});

var EasyFormView = widgets.BoxView.extend({
  render: function() {
    var that = this;

    EasyFormView.__super__.render.apply(this);

    this.$el
      .addClass('beaker-easyform-container')
      .addClass('widget-vbox');

    var formTitle = this.model.get('easyFormName');

    this.$fieldset = $('<fieldset></fieldset>').addClass('beaker-fieldset');
    this.$legend = $('<legend>'+formTitle+'</legend>');

    this.displayed.then(function() {
      that.$el.wrap(that.$fieldset);
      if (formTitle) {
        that.$el.before(that.$legend);
      }
    });
  }
});

module.exports = {
  EasyFormModel: EasyFormModel,
  EasyFormView: EasyFormView
};

_.extend(module.exports, buttonWidget);
_.extend(module.exports, selectMultipleWidget);
_.extend(module.exports, selectMultipleSingleWidget);
