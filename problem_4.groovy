// Largest palindrome product (Problem 4) (https://projecteuler.net/problem=4)

// A palindromic number reads the same both ways. The largest palindrome made
// from the product of two 2-digit numbers is 9009 = 91 × 99.

// Find the largest palindrome made from the product of two 3-digit numbers.

def n_digit_numbers(int n) {
    (10..<10.power(n))
}

 def is_palindrome(int n) {
    n.toString() == n.toString().reverse()
}

def find_palindromes_of_products(List<Integer> numbers) {
    ( 0..numbers.size().div(2)).inject([ ] ) { palindromes, x ->
        palindrome = (0..x).findResult { y ->
            product = numbers[x] * numbers[y]
            if ( is_palindrome(product) ) return product
        }
        palindromes << palindrome ?: []
    }
}

assert is_palindrome(1)
assert !is_palindrome(10)
assert is_palindrome(101)
assert !is_palindrome(5010)
assert is_palindrome(50105)

def two_digit_numbers = n_digit_numbers(2).reverse()
assert find_palindromes_of_products( two_digit_numbers ).max() == 9009

def three_digit_numbers = n_digit_numbers(3).reverse()
assert find_palindromes_of_products( three_digit_numbers ).max() == 906609

println "tests pass"
