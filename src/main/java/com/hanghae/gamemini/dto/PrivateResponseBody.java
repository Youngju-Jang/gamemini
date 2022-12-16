package com.hanghae.gamemini.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hanghae.gamemini.errorcode.StatusCode;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Builder
public class PrivateResponseBody<T> {
     private boolean success;
     private int statusCode;
     private String statusMsg;
     
     @JsonInclude (JsonInclude.Include.NON_EMPTY)
     private T data; // null 일경우 json에 안보내지도록
     
     public PrivateResponseBody(StatusCode statusCode) {
          this.statusCode = statusCode.getStatusCode();
          this.statusMsg = statusCode.getStatusMsg();
     }
     public PrivateResponseBody(StatusCode statusCode, T data){
          this.statusCode = statusCode.getStatusCode();
          this.statusMsg = statusCode.getStatusMsg();
          this.data = data;
     }
}
