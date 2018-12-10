var asciidoctor = require('asciidoctor.js')();
require('asciidoctor-reveal.js');

var attributes = {'revealjsdir': 'node_modules/reveal.js@', 'revealjs_history': true};
var options = {safe: 'safe', backend: 'revealjs', attributes: attributes, to_dir: 'output', mkdirs: true};
asciidoctor.convertFile('jsp.adoc', options); 

// Copie des assets nécessaires
const fs = require('fs-extra')
fs.copySync('node_modules/reveal.js', 'output/node_modules/reveal.js')

