package org.locationtech.curve.benchmarks

import org.locationtech.curve.zcurve._

import com.google.caliper.Param

object ZCurveBenchmark extends BenchmarkRunner(classOf[ZCurveBenchmark])

class ZCurveBenchmark extends CurveBenchmark {

  val xs2 = (0 until 300).toArray
  val ys2 = (0 until 300).toArray

  val xs3 = (0 until 200).toArray
  val ys3 = (0 until 200).toArray
  val zs3 = (0 until 200).toArray

  def timeZ2IndexCreate(reps: Int) = run(reps)(z2IndexCreation)
  def z2IndexCreation = {
    var x = 0
    var y = 0

    while(x < 300) {
      while(y < 300) {
        Z2(xs2(x), ys2(y))
        y += 1
      }
      x += 1
    }
  }

  def timeZ3IndexCreate(reps: Int) = run(reps)(z3IndexCreation)
  def z3IndexCreation = {
    var x = 0
    var y = 0
    var z = 0

    while(x < 200) {
      while(y < 200) {
        while(z < 200) {
          Z3(xs3(x), ys3(y), zs3(z))
          z += 1
        }
        y += 1
      }
      x += 1
    }
  }
}
