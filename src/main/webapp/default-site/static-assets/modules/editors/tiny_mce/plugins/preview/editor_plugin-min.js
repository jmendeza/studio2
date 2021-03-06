(function(){tinymce.create("tinymce.plugins.Preview",{init:function(f,e){var g=this,h=tinymce.explode(f.settings.content_css);
g.editor=f;
tinymce.each(h,function(a,b){h[b]=f.documentBaseURI.toAbsolute(a)
});
f.addCommand("mcePreview",function(){f.windowManager.open({file:f.getParam("plugin_preview_pageurl",e+"/preview.html"),width:parseInt(f.getParam("plugin_preview_width","550")),height:parseInt(f.getParam("plugin_preview_height","600")),resizable:"yes",scrollbars:"yes",popup_css:h?h.join(","):f.baseURI.toAbsolute("themes/"+f.settings.theme+"/skins/"+f.settings.skin+"/content.css"),inline:f.getParam("plugin_preview_inline",1)},{base:f.documentBaseURI.getURI()})
});
f.addButton("preview",{title:"preview.preview_desc",cmd:"mcePreview"})
},getInfo:function(){return{longname:"Preview",author:"Moxiecode Systems AB",authorurl:"http://tinymce.moxiecode.com",infourl:"http://wiki.moxiecode.com/index.php/TinyMCE:Plugins/preview",version:tinymce.majorVersion+"."+tinymce.minorVersion}
}});
tinymce.PluginManager.add("preview",tinymce.plugins.Preview)
})();