package main

import "fmt"

func main() {
	var a, b float64
	fmt.Scanf("%f %f", &a, &b)
	fmt.Printf("%.9f\n", a/b)
}