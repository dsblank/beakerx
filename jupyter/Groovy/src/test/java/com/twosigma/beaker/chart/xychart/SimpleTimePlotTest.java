/*
 *  Copyright 2014 TWO SIGMA OPEN SOURCE, LLC
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.twosigma.beaker.chart.xychart;

import com.twosigma.beaker.fileloader.CsvPlotReader;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SimpleTimePlotTest {

  @Test
  public void shouldCreateSimpleTimePlot() throws Exception {
    //given
    String pathToTableRowTest = getClass().getClassLoader().getResource("tableRowsTest.csv").getPath();
    List<Map<String, Object>> rates = new CsvPlotReader().read(pathToTableRowTest);
    //when
    SimpleTimePlot simpleTimePlot = new SimpleTimePlot(rates, Arrays.asList("y1", "y10"));
    //then
    Assertions.assertThat(simpleTimePlot).isNotNull();
  }
}