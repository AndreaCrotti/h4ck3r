(ns h4ck3r.core-test
  (:require [h4ck3r.core :refer [convert]]
            [clojure.test :refer :all]))

;;TODO: more declarative way to define input

(def input-outputs
  [{:string "Hello world" :strategy :trim :output "He wo"}
   {:string "Hello world" :strategy :cons :output "Hll wrld"}
   {:string "Hello world" :strategy :obfu :output "H3ll0 w0r1d"}])

(deftest conversion-test
  (testing "Trim words"
    (let [res (convert "Hello world"  :trim)]
      (is (= "He wo" (:shortened res)))
      (is (= {"Hello" "He", "world" "wo"} (:mapping res)))))

  (testing "Remove consonants"
    (let [res (convert "Hello world" :cons)]
      (is (= "Hll wrld" (:shortened res)))))

  (testing "Obfuscate"))

;;TODO: find out why dynamic declaration like this does not work
#_(deftest conversion-test-dynamic
    (for [inp-put input-outputs]
      (testing (str (:stategy inp-put))
        (is (= (:output inp-put) (convert (:string inp-put) (:strategy inp-out)))))))
