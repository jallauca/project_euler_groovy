// Largest palindrome product (Problem 4) (https://projecteuler.net/problem=4)

// A palindromic number reads the same both ways. The largest palindrome made
// from the product of two 2-digit numbers is 9009 = 91 × 99.

// Find the largest palindrome made from the product of two 3-digit numbers.

// Solution Tips:
// Iterate x and y, where x in numbers and y in numbers in descending order,
// so that the first x*y that is palindrome means returning the highest

def n_digit_numbers(int n) {
    (10.power(n-1)..<10.power(n))
}

 def is_palindrome(int n) {
    n.toString() == n.toString().reverse()
}

def find_each_palindrome_of_products(List<Integer> numbers) {
    ( numbers.size()-1..<0 ).collect { int x ->
        palindrome = (x-1..0).findResult { int y ->
            product = numbers[x] * numbers[y]
            is_palindrome(product) ? product : null
        }
        palindrome ?: 0
    }
}

assert is_palindrome(1)
assert !is_palindrome(10)
assert is_palindrome(101)
assert !is_palindrome(5010)
assert is_palindrome(50105)

def two_digit_numbers = n_digit_numbers(2)
def three_digit_numbers = n_digit_numbers(3)

assert find_each_palindrome_of_products( three_digit_numbers ).max() == 906609
assert find_each_palindrome_of_products( two_digit_numbers ).max() == 9009

println "tests pass"
