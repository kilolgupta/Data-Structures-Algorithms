def random_string(size):
    chars = 'AAAAAAAAAAT'
    return ''.join(random_string(chars) for _ in range(size))

def gen():
    text = random_string(10000)
    patterns = []
    for i in range(5000):
        patterns.append(random_string(14))

    return text, patterns

def solve_bf(text, n, patterns):
    result = []
    o_text = text
    for i in range(len(text)):
        for p in patterns:
            if p == text[i:(i+len(p))]:
                result.append(i)
    return list(set(result))



def main():
     text, patterns = gen()