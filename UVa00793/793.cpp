#include<iostream>
#include<sstream>
#include<string>
using namespace std;

class UF {
  private:
    int *p, *sz;

    int getRoot(int);
  public:
    UF(int);
    ~UF();
    void join(int, int);
    bool query(int, int);
};

UF::UF(int len) {
  p = new int[len];
  sz = new int[len];
  for (int i = 0; i < len; i++) {
    p[i] = i;
    sz[i] = 1;
  }
}

UF::~UF() {
  delete[] p;
  delete[] sz;
}

int UF::getRoot(int a) {
  int currNode = a;
  while (currNode != p[currNode]) {
    p[currNode] = p[p[currNode]];
    currNode = p[currNode];
  }

  p[a] = currNode;
  return currNode;
}

void UF::join(int a, int b) {
  if (sz[a] > sz[b]) { //assert sz[a] <= sz[b]
    join(b, a);
  }
  else {
    int aR = getRoot(a), bR = getRoot(b);
    p[aR] = bR;
    sz[bR] += sz[aR];
  }
}

bool UF::query(int a, int b) {
  return getRoot(a) == getRoot(b);
}

int main() {
  int lim;
  cin >> lim;

  for (int test = 0; test < lim; test++) {
    int netSize;

    cin >> netSize;

    UF network(netSize+1);

    int s = 0, f = 0;
    string line;
    getline(cin, line);
    getline(cin, line);
    while(!line.empty()) {
      char c;
      int a, b;
      istringstream iss(line);
      iss >> c >> a >> b;
      
      if (c == 'q') {
        if (network.query(a, b))
          s++;
        else
          f++;
      }
      else {
        network.join(a, b);
      }

      getline(cin, line);
    }

    cout << s << "," << f << endl;
    if (test != lim-1)
      cout << endl;
  }
  
  
  return 0;
}
