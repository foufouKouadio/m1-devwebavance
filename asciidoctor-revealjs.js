var asciidoctor = require('asciidoctor.js')();
require('asciidoctor-reveal.js');

var attributes = {'revealjsdir': 'node_modules/reveal.js@'};
var options = {safe: 'safe', backend: 'revealjs', attributes: attributes, to_dir: 'output', mkdirs: true};
asciidoctor.convertFile('jsp.adoc', options); 
