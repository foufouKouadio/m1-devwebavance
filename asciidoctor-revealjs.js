var asciidoctor = require('asciidoctor.js')();
require('asciidoctor-reveal.js');
const plantuml = require('asciidoctor-plantuml');
plantuml.register(asciidoctor.Extensions);

var attributes = {
    'revealjsdir': 'node_modules/reveal.js@', 
    'revealjs_history': true,
    'revealjs_theme': 'black',
    'revealjs_width': 1280,
    'revealjs_height': 720
};
var options = {safe: 'safe', backend: 'revealjs', attributes: attributes, to_dir: 'output', mkdirs: true};
asciidoctor.convertFile('jsp.adoc', options); 
asciidoctor.convertFile('injection-dependances.adoc', options); 
asciidoctor.convertFile('rest.adoc', options); 

// Copie des assets nécessaires
const fs = require('fs-extra')
fs.copySync('node_modules/reveal.js', 'output/node_modules/reveal.js')

