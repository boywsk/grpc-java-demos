/*
 * Copyright 2016 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.grpc.server;

import com.example.server.GreetingRequest;
import com.example.server.GreetingResponse;
import com.example.server.GreetingServiceGrpc;
import io.grpc.stub.StreamObserver;

/**
 * Created by rayt on 5/16/16.
 */
public class GreetingServiceImpl implements GreetingServiceGrpc.GreetingService {
  @Override
  public void greet(GreetingRequest request, StreamObserver<GreetingResponse> responseObserver) {
    System.out.println(request);

    responseObserver.onNext(GreetingResponse.newBuilder().setGreeting("Hello " + request.getName()).build());
    responseObserver.onCompleted();
  }
}
