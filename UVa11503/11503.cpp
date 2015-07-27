#include<iostream>
#include<map>
#include<string>
using namespace std;

class UF {
  private:
    int len;
    int* p;
    int* sz;
    int getRoot(int);
  public:
    bool query(int, int);
    void join(int, int);
    int size(int);
    UF(int);
    ~UF();
};

UF::UF(int len) {
  this->len=len;
  p = new int[len];
  sz = new int[len];
  for(int i = 0; i < len; i++) {
    p[i] = i;
    sz[i] = 1; 
  }
}

UF::~UF() {
  delete[] p;
  delete[] sz;
}

int UF::getRoot(int a) {
  int cN = a;
  while (p[cN] != cN) 
    cN = (p[cN] = p[p[cN]]);

  return p[a] = cN;
}

void UF::join(int a, int b) {
  int rA = getRoot(a), rB = getRoot(b);
  if (rA == rB) return; //Don't join already joined stuff!

  if (sz[rA] > sz[rB]) 
    swap(rA, rB);

  p[rA] = rB;
  sz[rB] += sz[rA];
}

bool UF::query(int a, int b) {
  return getRoot(a) == getRoot(b);
}

int UF::size(int a) {
  return sz[getRoot(a)];
}

int main() {
  ios::sync_with_stdio(false);
  
  int testCt;
  cin >> testCt;
  for (int test = 0; test < testCt; test++) {
    int f;
    cin >> f;
    UF uf(2*f);
    
    map <string, int> m;
    int currNum = 0;
    for (int i = 0; i < f; i++) {
      string s1, s2;
      cin >> s1 >> s2;
      if (m.count(s1) == 0)
        m[s1] = currNum++;
      if (m.count(s2) == 0)
        m[s2] = currNum++;
      
      uf.join(m[s1], m[s2]);
      cout << uf.size(m[s1]) << endl;
    }
  }
}
