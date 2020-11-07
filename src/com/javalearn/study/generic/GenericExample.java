package com.javalearn.study.generic;

//
//. Создайте интерфейс Result
//        1. Два generic: response и error
//        2. Два метода: Boolean isError(), <> getResponse()
//        2. Создайте 2 реализации EcmResult<EcmResponse, EcmError> и UpdateResult<UpdateResponse, UpdateError>
//        3. В каждом классе два поля: response и error
//        4. Реализуйте методы интерфейса
//        5. Создайте конструкторы, принимающие на вход два поля


public class GenericExample  {



    class EcmResult<EcmResponse, EcmError> implements Result<EcmResponse, EcmError>{
        EcmResponse response;
        EcmError error;

        public EcmResult(EcmResponse response, EcmError error) {
            this.response = response;
            this.error = error;
        }
        @Override
        public Boolean isError() {
            if (error!=null){
                return true;
            } else {
                return false;
            }
        }

        @Override
        public EcmResponse getResponse() {
            return this.response;
        }

    }
}

interface Result<R,E>{

     Boolean isError();
     R getResponse();

}