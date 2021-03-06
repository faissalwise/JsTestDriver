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
package com.google.jstestdriver;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.Option;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jeremiele@google.com (Jeremie Lenfant-Engelmann)
 */
public class FlagsImpl implements Flags {

  private Integer port = -1;
  private String server;
  private String testOutput = "";
  private List<String> browser = new ArrayList<String>();
  private boolean reset;
  private String config = "jsTestDriver.conf";
  private List<String> tests = new ArrayList<String>();
  private boolean displayHelp = false;
  private boolean verbose = false;
  private boolean captureConsole = false;
  @Argument
  private List<String> arguments = new ArrayList<String>();

  @Option(name="--port", usage="The port on which to start the JsTestDriver server")
  public void setPort(Integer port) {
    this.port = port;
  }

  public Integer getPort() {
    return port;
  }

  @Option(name="--server", usage="The server to which to send the command")
  public void setServer(String server) {
    this.server = server;
  }

  public String getServer() {
    return server;
  }

  public List<String> getArguments() {
    return arguments;
  }

  @Option(name="--testOutput", usage="A directory to which serialize the results of the tests as" +
  		" XML")
  public void setTestOutput(String testOutput) {
    this.testOutput = testOutput;
  }

  public String getTestOutput() {
    return testOutput;
  }

  @Option(name="--browser", usage="The path to the browser executable")
  public void setBrowser(String browser) {
    this.browser = Arrays.asList(browser.split(","));
  }

  public List<String> getBrowser() {
    return browser;
  }

  @Option(name="--reset", usage="Resets the runner")
  public void setReset(boolean reset) {
    this.reset = reset;
  }

  public boolean getReset() {
    return reset;
  }

  @Option(name="--config", usage="Loads the configuration file")
  public void setConfig(String config) {
    this.config = config;
  }

  public String getConfig() {
    return config;
  }

  @Option(name="--tests", usage="Run the tests specified in the form testCase.testName")
  public void setTests(String tests) {
    this.tests = Arrays.asList(tests.split(","));
  }

  public List<String> getTests() {
    return tests;
  }

  @Option(name="--help", usage="Help")
  public void setDisplayHelp(boolean displayHelp) {
    this.displayHelp = displayHelp;
  }

  public boolean getDisplayHelp() {
    return displayHelp;
  }

  @Option(name="--verbose", usage="Displays more information during a run")
  public void setVerbose(boolean verbose) {
    this.verbose = verbose;
  }

  public boolean getVerbose() {
    return verbose;
  }

  @Option(name="--captureConsole", usage="Capture the console (if possible) from the browser")
  public void setCaptureConsole(boolean captureConsole) {
    this.captureConsole = captureConsole;
  }

  public boolean getCaptureConsole() {
    return captureConsole;
  }
}
