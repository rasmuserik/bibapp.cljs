(defproject bibapp "0.1.0-SNAPSHOT"
  :description "Mobile/html5 public library app."
  :url "http://github.com/rasmuserik/bibapp"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [org.clojure/clojurescript "0.0-1552"]
                 [crate "0.2.3"]]
  :plugins [[lein-cljsbuild "0.2.10"]]
  :cljsbuild {
    :crossovers [common.templates]
    :builds [{
      :source-path "src/bibapp"
      :compiler {
        :output-to "resources/public/main.js"
        :optimizations :whitespace
        :pretty-print true
        ;:optimizations :advanced
        ;:pretty-print false
                 }}]})
