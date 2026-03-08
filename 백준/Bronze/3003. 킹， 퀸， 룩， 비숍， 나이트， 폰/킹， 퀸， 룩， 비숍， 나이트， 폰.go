package main

import "fmt"

func main() {
	fullPiece := [6]int{1, 1, 2, 2, 2, 8}
	var input [6]int

	fmt.Scanf("%d %d %d %d %d %d",
		&input[0], &input[1], &input[2], &input[3], &input[4], &input[5])

	for idx := range fullPiece {
		fmt.Printf("%d ", fullPiece[idx]-input[idx])
	}
	fmt.Printf("\n")

}
