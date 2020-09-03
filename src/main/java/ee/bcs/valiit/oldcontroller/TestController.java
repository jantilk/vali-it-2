package ee.bcs.valiit.oldcontroller;

import ee.bcs.valiit.Lessons.Employee;
import ee.bcs.valiit.Lessons.Lesson1MathUtil;
import ee.bcs.valiit.Lessons.Lesson2;
import ee.bcs.valiit.Lessons.Lesson3;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    private final List<Employee> employees = new ArrayList();

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

    // week 2 day 1

    @GetMapping("employees")
    public List<Employee> getEmployees() {
        return employees;
    }

    @GetMapping("employees/{index}")
    public Employee getEmployeeByIndex(@PathVariable("index") Integer index) {
        return employees.get(index);
    }

    @PutMapping("employees/{index}")
    public Employee putEmployee(@RequestBody() Employee employee, @PathVariable("index") Integer index) {
        employees.set(index, employee);
        return employees.get(index);
    }

    @PostMapping("employees")
    public void postEmployee(@RequestBody() Employee employee){
        System.out.println(employee.getEmployee());
        employees.add(employee);
    }

    @DeleteMapping("employees/{index}")
    public void deleteEmployeeByIndex(@PathVariable("index") int index) {
        System.out.println("Delete " + employees.get(index));

        employees.remove(index);
    }






}
