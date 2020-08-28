package ee.bcs.valiit.controller;

import ee.bcs.valiit.Lesson1MathUtil;
import ee.bcs.valiit.Lesson2;
import ee.bcs.valiit.Lesson3;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    //@GetMapping(value="/")
    //public String getHelloWorld(){
    //    return "Hello World";
    //}

    @GetMapping("min")
    public int min(@RequestParam("x") int x, @RequestParam("y") int y) {
        return Lesson1MathUtil.min(x, y);
    }

    @GetMapping("max")
    public int max(@RequestParam("x") int x, @RequestParam("y") int y) {
        return Lesson1MathUtil.max(x, y);
    }

    @GetMapping("abs")
    public int abs(@RequestParam("x") int x) {
        return Lesson1MathUtil.abs(x);
    }

    @GetMapping("isEven")
    public boolean isEven(@RequestParam("x") int x) {
        return Lesson1MathUtil.isEven(x);
    }

    @GetMapping("min3")
    public int min3(@RequestParam("x") int x, @RequestParam("y") int y, @RequestParam("z") int z) {
        return Lesson1MathUtil.min(x, y, z);
    }

    @GetMapping("max3")
    public int max3(@RequestParam("x") int x, @RequestParam("y") int y, @RequestParam("z") int z) {
        return Lesson1MathUtil.max(x, y, z);
    }

    @GetMapping("xyTable")
    public String xyTable(@RequestParam("x") int x, @RequestParam("y") int y) {
        return Lesson2.xyTable(x, y);
    }

    @GetMapping("fibbonaci")
    public Integer fibonacci(@RequestParam("fibonacci") Integer n) {
        return Lesson2.fibonacci(n);
    }

    @GetMapping("algorithm")
    public String algorithm(@RequestParam("x") Integer x, @RequestParam("y") Integer y) {
        return Lesson2.algorithm(x, y);
    }

    @GetMapping("factorial")
    public Integer factorial(@RequestParam("x") Integer x) {
        return Lesson3.factorial(x);
    }

    @GetMapping("reverse")
    public String factorial(@RequestParam("reverse") String reverse) {
        return Lesson3.reverseString(reverse);
    }

    @GetMapping("isPrime")
    public Boolean isPrime(@RequestParam("x") Integer x) {
        return Lesson3.isPrime(x);
    }

}
