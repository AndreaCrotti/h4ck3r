(ns h4ck3r.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [h4ck3r.handler :refer :all]))

(deftest test-app
  (testing "translator"
    (let [response (app (mock/request :post "/translate" {:message "Hello world"}))]
      (is (= (:status response) 200))
      (is (= (:content response) "He wo"))))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404)))))
