(ns h4ck3r.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [h4ck3r.handler :refer :all]))

(def desired {:shortened "He wo", :mapping {"Hello" "He", "world" "wo"}})

(deftest test-app
  (testing "translator"
    (let [response (app (mock/request :post "/translate" {:message "Hello world"}))]
      (is (= 200 (:status response)))
      (is (= desired (:body response)))))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404)))))
