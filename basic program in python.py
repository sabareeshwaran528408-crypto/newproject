def fibonacci(n):
    sequence = []
    a, b = 0, 1
    for _ in range(n):
        sequence.append(a)
        a, b = b, a + b
    return sequence

# Example usage
num_terms = 10
print(f"First {num_terms} Fibonacci numbers:")
print(fibonacci(num_terms))
