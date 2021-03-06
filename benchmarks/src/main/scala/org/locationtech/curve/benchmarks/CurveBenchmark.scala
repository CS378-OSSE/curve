package org.locationtech.curve.benchmarks

import com.google.caliper.Benchmark
import com.google.caliper.Runner
import com.google.caliper.SimpleBenchmark

abstract class BenchmarkRunner(cls: java.lang.Class[_ <: Benchmark]) {
  def main(args: Array[String]): Unit = Runner.main(cls, args: _*)
}

trait CurveBenchmark extends SimpleBenchmark {
  /**
    * Sugar to run 'f' for 'reps' number of times.
    */
  def run(reps: Int)(f: => Unit) = {
    var i = 0
    while (i < reps) { f; i += 1 }
  }
}
