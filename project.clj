(defproject h4ck3r "0.1.0-SNAPSHOT"
  :description "Fun with strings"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0-RC4"]
                 [compojure "1.4.0"]
                 [ring/ring-defaults "0.1.5"]
                 [ring/ring-jetty-adapter "1.4.0"]

                 ;; [de.ubercode.clostache/clostache "1.4.0"]
                 [selmer "0.9.6"]

                 [prismatic/schema "1.0.4"]
                 [com.cemerick/friend "0.2.1"]
                 [clj-jwt "0.1.1"]

                 [org.clojure/tools.cli "0.3.3"]
                 [org.clojure/data.json "0.2.6"]
                 [http-kit "2.1.19"]
                 [environ "1.0.1"]
                 [metosin/scjsv "0.2.0"]
                 
                 [ring/ring-json "0.4.0"]
                 [metosin/ring-swagger "0.22.1"]
                 [metosin/ring-swagger-ui "2.1.8-M1"]
                 [metosin/ring-http-response "0.6.5"]
                 [ring/ring-defaults "0.1.5"]
                 [ring-middleware-format "0.7.0" :exclusions [ring]]]
  :plugins [[lein-ring "0.9.7"]
            [environ/environ.lein "0.3.1"]]
  :ring {:handler h4ck3r.handler/app
         :auto-reload? true
         :auto-refresh? true}
  :uberjar-name "h4ck3r-standalone.jar"
  :hooks [environ.leiningen.hooks]
  :profiles
  {:production {:env {:production true}}
   :dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                          [ring/ring-mock "0.3.0"]]}})
