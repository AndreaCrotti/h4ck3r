(defproject h4ck3r "0.1.0-SNAPSHOT"
  :description "Fun with strings"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0-RC4"]
                 [compojure "1.4.0"]
                 [ring/ring-defaults "0.1.5"]

                 [http-kit "2.1.19"]
                 [environ "1.0.0"]
                 [metosin/ring-swagger "0.20.4"]
                 [metosin/ring-swagger-ui "2.1.8-M1"]
                 [metosin/ring-http-response "0.6.4"]
                 [ring/ring-defaults "0.1.5"]
                 [ring-middleware-format "0.5.0" :exclusions [ring]]]
  :plugins [[lein-ring "0.9.7"]
            [environ/environ.lein "0.3.1"]]
  :ring {:handler h4ck3r.handler/app}
  :uberjar-name "h4ck3r-standalone.jar"
  :hooks [environ.leiningen.hooks]
  :profiles
  {:production {:env {:production true}}
   :dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                          [ring/ring-mock "0.3.0"]]}})
