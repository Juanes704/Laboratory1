#include <iostream>

extern "C" {
    int findMax(int* numbers, int length) {
        if (numbers == nullptr || length <= 0) {
            return 0; // Manejo de error, puedes personalizarlo.
        }

        int max = numbers[0];
        for (int i = 1; i < length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        return max;
    }
}
