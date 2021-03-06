/*
 * Copyright 2009 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
var heartbeatTest = jstestdriver.testCaseManager.TestCase('heartbeatTest');

heartbeatTest.prototype.testStartHeartbeat = function() {
  var callbackCalled = false;
  var url;
  var data;
  var called = false;
  var heartbeat = new jstestdriver.Heartbeat("1", "/heartbeat", function(_url, _data, _callback) {
    url = _url;
    data = _data;
    called = true;
  }, 30);

  heartbeat.sendHeartbeat();
  assertEquals("/heartbeat", url);
  assertEquals("1", data.id);
  assertTrue(called);
};
