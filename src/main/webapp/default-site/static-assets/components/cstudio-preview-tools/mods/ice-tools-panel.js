CStudioAuthoring.Utils.addJavascript("/static-assets/modules/editors/tiny_mce/tiny_mce.js");
CStudioAuthoring.Utils.addJavascript("/static-assets/components/cstudio-forms/forms-engine.js");

var initRegCookie;
/**
 * editor tools
 */
CStudioAuthoring.IceToolsPanel = CStudioAuthoring.IceToolsPanel || {

	initialized: false,
	
	/**
	 * initialize module
	 */
	initialize: function(config) {
		if(this.initialized == false) {
			this.initialized = true;
		}
	},
	
	render: function(containerEl, config) {

        var container = document.createElement('div'),
            wrapper;

        containerEl.appendChild(container);
        container.className = 'studio-view';

	    var buttonEl, imageEl, labelEl, iceOn;

        wrapper = document.createElement('div');
		buttonEl = document.createElement("button");
		imageEl = document.createElement("img");
        labelEl = document.createElement("span");
        YDom.addClass(wrapper, 'form-group');
        YDom.addClass(buttonEl, 'btn btn-default btn-block');
        YDom.addClass(labelEl, 'acn-ptools-ice-label');

		iceOn = !!(sessionStorage.getItem('ice-on'));   // cast string value to a boolean

		if (iceOn) {
    	    imageEl.src = CStudioAuthoringContext.authoringAppBaseUri + "/static-assets/themes/cstudioTheme/images/edit.png";
    	    labelEl.innerHTML = CMgs.format(previewLangBundle, "inContextEditOff");
		} else {
            imageEl.src = CStudioAuthoringContext.authoringAppBaseUri + "/static-assets/themes/cstudioTheme/images/edit_off.png";
            labelEl.innerHTML = CMgs.format(previewLangBundle, "inContextEditOn");
		}

		buttonEl.appendChild(imageEl);
        buttonEl.appendChild(labelEl);
        wrapper.appendChild(buttonEl);
		container.appendChild(wrapper);

		buttonEl.onclick = function() {
		    var iceOn = !!(sessionStorage.getItem('ice-on'));   // cast string value to a boolean
			if(!iceOn) {
				CStudioAuthoring.IceTools.turnEditOn();
			} else {
				CStudioAuthoring.IceTools.turnEditOff();
			}
		};

        wrapper = document.createElement('div');
		var regionSelectEl = document.createElement("select");

        YDom.addClass(wrapper, "form-group");
        YDom.addClass(regionSelectEl, "form-control");

        wrapper.appendChild(regionSelectEl);
        container.appendChild(wrapper);

        wrapper = document.createElement('div');
        YDom.addClass(wrapper, "edit-code template");
		var templateButtonEl = document.createElement("button");
		var templateImageEl = document.createElement("img");
		var templateLabelEl = document.createElement("span");

        templateImageEl.src = CStudioAuthoringContext.authoringAppBaseUri + "/static-assets/themes/cstudioTheme/images/icons/code-edit.gif";
    	templateLabelEl.innerHTML = CMgs.format(previewLangBundle, "editTemplate");

        // YDom.addClass(wrapper, 'form-group');
        YDom.addClass(templateButtonEl, 'btn btn-default btn-block');
        YDom.addClass(templateLabelEl, 'acn-ptools-ice-label');

        templateButtonEl.appendChild(templateImageEl);
        templateButtonEl.appendChild(templateLabelEl);
        wrapper.style.marginleft = "4px";
        wrapper.appendChild(templateButtonEl);

        container.appendChild(wrapper);

        wrapper = document.createElement('div');
        YDom.addClass(wrapper, "edit-code");
        var controllerButtonEl = document.createElement("button");
        var controllerImageEl = document.createElement("img");
        var controllerLabelEl = document.createElement("span");

        controllerImageEl.src = CStudioAuthoringContext.authoringAppBaseUri + "/static-assets/themes/cstudioTheme/images/icons/code-edit.gif";
        controllerLabelEl.innerHTML = CMgs.format(previewLangBundle, "editController");

        // YDom.addClass(wrapper, 'form-group');
        YDom.addClass(controllerButtonEl, 'btn btn-default btn-block');
        YDom.addClass(controllerLabelEl, 'acn-ptools-ice-label');

        controllerButtonEl.appendChild(controllerImageEl);
        controllerButtonEl.appendChild(controllerLabelEl);
        wrapper.appendChild(controllerButtonEl);

        container.appendChild(wrapper);

        initRegCookie = function(){

            try {
                var regions = JSON.parse(sessionStorage.getItem('ice-tools-content'));

                for (i = 0; i < regionSelectEl.length; i++) {
                    regionSelectEl.options[i] = null;
                }

                if (regions.length > 0) {

                    regionSelectEl.options[0] = new Option(CMgs.format(previewLangBundle, "jumpToRegion"), "0", true, false);
                    for (var i = 0; i < regions.length; i++) {
                        var label = (regions[i].label)
                            ? regions[i].label
                            : regions[i].id;
                        regionSelectEl.options[i + 1] = new Option(label, '' + (i + 1), false, false);
                    }

                    regionSelectEl.onchange = function () {
                        var selectedIndex = this.selectedIndex;
                        if (selectedIndex != 0) {
                            var region = regions[selectedIndex - 1];
                            if (region.label) {
                                amplify.publish(cstopic('ICE_TOOLS_REGIONS'), {label: '-label', region: region.label});
                            } else {
                                amplify.publish(cstopic('ICE_TOOLS_REGIONS'), {label: '', region: region.id});
                            }
                        }
                    };
                } else {
                    regionSelectEl.options[0] = new Option("No Regions", "0", true, false);
                }
            }
            catch (err) {
                if (window.console && window.console.log) {
                    console.log(err);
                }
            }
        }

        templateButtonEl.onclick = function() {
            if(CStudioAuthoring.SelectedContent.getSelectedContent()[0].renderingTemplates.length > 0) {
                var contentType = CStudioAuthoring.SelectedContent.getSelectedContent()[0].renderingTemplates[0].uri;

                // if(CStudioAuthoringContext.channel && CStudioAuthoringContext.channel != "web") {
                // 		contentType = contentType.substring(0, contentType.lastIndexOf(".ftl")) +
                // 			"-" + CStudioAuthoringContext.channel + ".ftl";
                // }

                CStudioAuthoring.Operations.openTemplateEditor(contentType, "default", {
                    success: function () {
                        CStudioAuthoring.Operations.refreshPreview();
                    },
                    failure: function () {
                    }
                });
            }else{
                alert("No template found");
            }
		};

        controllerButtonEl.onclick = function() {
            if(CStudioAuthoring.SelectedContent.getSelectedContent()[0].contentType) {
                var contentType = CStudioAuthoring.SelectedContent.getSelectedContent()[0].contentType.split("/");
                var path = "/scripts/pages/" + contentType[contentType.length - 1] + ".groovy";

                CStudioAuthoring.Operations.openTemplateEditor(path, "default", {
                    success: function () {
                        //CStudioAuthoring.Operations.refreshPreview();
                        location.reload();
                    },
                    failure: function () {
                    }
                });
            }else{
                alert("No controller found");
            }
        };
        var contextNavImg = YDom.get("acn-ice-tools-image");
        var cstopic = crafter.studio.preview.cstopic;

        CStudioAuthoring.IceTools.IceToolsOffEvent.subscribe(function() {
            imageEl.src = CStudioAuthoringContext.authoringAppBaseUri + "/static-assets/themes/cstudioTheme/images/edit_off.png";
            contextNavImg.src = CStudioAuthoringContext.authoringAppBaseUri + "/static-assets/themes/cstudioTheme/images/edit_off.png";
            labelEl.innerHTML = CMgs.format(previewLangBundle, "inContextEditOn");

            amplify.publish(cstopic('ICE_TOOLS_OFF'));

        });

        CStudioAuthoring.IceTools.IceToolsOnEvent.subscribe(function() {
            imageEl.src = CStudioAuthoringContext.authoringAppBaseUri + "/static-assets/themes/cstudioTheme/images/edit.png";
            contextNavImg.src = CStudioAuthoringContext.authoringAppBaseUri + "/static-assets/themes/cstudioTheme/images/edit.png";
            YDom.replaceClass(containerEl.parentNode, 'contracted', 'expanded');
            labelEl.innerHTML = CMgs.format(previewLangBundle, "inContextEditOff");

            amplify.publish(cstopic('ICE_TOOLS_ON'));

        });
		
		if(iceOn) {
			CStudioAuthoring.IceTools.turnEditOn();
		}

        // Create the event
        var event = new CustomEvent("name-of-event", { "detail": "Example of an event" });

// Dispatch/Trigger/Fire the event
        document.dispatchEvent(event);
	}
}

CStudioAuthoring.Module.moduleLoaded("ice-tools-panel", CStudioAuthoring.IceToolsPanel);