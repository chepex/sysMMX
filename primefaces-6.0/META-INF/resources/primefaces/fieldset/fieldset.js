PrimeFaces.widget.Fieldset=PrimeFaces.widget.BaseWidget.extend({init:function(a){this._super(a);this.legend=this.jq.children(".ui-fieldset-legend");var b=this;if(this.cfg.toggleable){this.content=this.jq.children(".ui-fieldset-content");this.toggler=this.legend.children(".ui-fieldset-toggler");this.stateHolder=$(this.jqId+"_collapsed");this.legend.on("click",function(c){b.toggle(c)}).on("mouseover",function(){b.legend.toggleClass("ui-state-hover")}).on("mouseout",function(){b.legend.toggleClass("ui-state-hover")}).on("mousedown",function(){b.legend.toggleClass("ui-state-active")}).on("mouseup",function(){b.legend.toggleClass("ui-state-active")}).on("focus",function(){b.legend.toggleClass("ui-state-focus")}).on("blur",function(){b.legend.toggleClass("ui-state-focus")}).on("keydown",function(f){var c=f.which,d=$.ui.keyCode;if((c===d.ENTER||c===d.NUMPAD_ENTER)){b.toggle(f);f.preventDefault()}})}},toggle:function(b){this.updateToggleState(this.cfg.collapsed);var a=this;this.content.slideToggle(this.cfg.toggleSpeed,"easeInOutCirc",function(){if(a.cfg.behaviors){var c=a.cfg.behaviors.toggle;if(c){c.call(a)}}});PrimeFaces.invokeDeferredRenders(this.id)},updateToggleState:function(a){if(a){this.toggler.removeClass("ui-icon-plusthick").addClass("ui-icon-minusthick")}else{this.toggler.removeClass("ui-icon-minusthick").addClass("ui-icon-plusthick")}this.cfg.collapsed=!a;this.stateHolder.val(!a)}});