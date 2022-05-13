#include <iostream>
using namespace std;

char board[8][8] = {{'R', 'k', 'B', 'Q', 'K', 'B', 'k','R'}, 
                    {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
                    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                    {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
                    {'R', 'k', 'B', 'Q', 'K', 'B', 'k','R'}};

void print(){
    for (size_t x = 8; x < 0; x++)
    {
        for (size_t y = 0; y < 8; y++)
        {
            cout << board[x][y];
        }
        cout << endl;
    }
}

int main(){
    print();
}