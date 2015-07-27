#include<iostream>
#include<string>
#include<vector>
using namespace std;

class UF {
  private:
    int* p;
    int* sz;
    int len;
    int getRoot(int);
  public:
    UF(int);
    ~UF();
    void join(int, int);
    int size(int);
    bool query(int, int);
};

UF::UF(int s) {
  len = s;
  p = new int[s];
  sz = new int[s];
  for (int i = 0; i < s; i++) {
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
  while (cN != p[cN])
    cN = (p[cN] = p[p[cN]]);

  p[a] = cN;
  return cN;
}

void UF::join(int a, int b) {
  if (query(a, b))
    return;

  int rA = getRoot(a), rB = getRoot(b);
  if (sz[rA] > sz[rB]) {
    join(b, a);
  }
  else {
    p[rA] = rB;
    sz[rB] += sz[rA];
  }
}

bool UF::query(int a, int b) {
  return getRoot(a) == getRoot(b);
}

int UF::size(int a) {
  return sz[getRoot(a)];
}

int main() {
  while (cin.good()) {
    int nodes, edges;
    cin >> nodes >> edges;
    string init; // starting active nodes
    cin >> init; 


    // Let's read this graph!
    vector<int>* adj[26];
    for (int i = 0; i < 26; i++)
      adj[i] = new vector<int>();
    
    string tmp;
    for (int i = 0; i < edges; i++) {
      cin >> tmp;
      adj[tmp[0] - 'A']->push_back(tmp[1] - 'A');
      adj[tmp[1] - 'A']->push_back(tmp[0] - 'A');
    }

    UF uf(26);
    char aRep = init[0] - 'A'; //Active representative
    uf.join(init[0] - 'A', init[1] - 'A');
    uf.join(init[1] - 'A', init[2] - 'A');
    
    int oldSz = 0;
    int years = 0;
    while (oldSz != uf.size(aRep)) {
      oldSz = uf.size(aRep);
      int newRep = -1;
      for (int i = 0; i < 26; i++) {
        if (uf.query(i, aRep)) continue; // only care about non-active cells

        int activeNeighbors = 0;
        for (vector<int>::iterator it = adj[i]->begin(); it != adj[i]->end(); it++) {
          if (uf.query(*it, aRep))
            activeNeighbors++;
        }

        if (activeNeighbors >= 3) {
          if (newRep == -1)
            newRep = i;
          else
            uf.join(newRep, i);
        }
      }

      if (newRep != -1)
        uf.join(newRep, aRep);
      years++;
    }

    if (uf.size(aRep) == nodes)
      cout << "WAKE UP IN, " << years-1 << ", YEARS\n"; 
    else
      cout << "THIS BRAIN NEVER WAKES UP\n";

    string dummy;
    getline(cin, dummy);
    getline(cin, dummy);
  }
  return 0;
}
