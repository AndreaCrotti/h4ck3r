(ns h4ck3r.web
  (:require [h4ck3r.handler :refer :all]
            [environ.core :refer [env]]))


(defn -main [& [port]]
  (let [port (Integer. (or port (env :port) 5000))]
    (jetty/run-jetty (site #'app) {:port port :join? false})))
