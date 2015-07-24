#!/usr/bin/python3

import random

for i in range(10001):
  a = random.randint(1, 10000)
  b = random.randint(1, a+10)
  print(a, b)
print("0 0")

