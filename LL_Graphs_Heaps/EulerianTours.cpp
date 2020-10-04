#include <bits/stdc++.h>
using namespace std;

#define IOS ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#define endl "\n"
#define int long long

const int N=1e5+5;

int n;
vector<pair<int,int> > g[N];
int sz[N];
int cnt[N];

void dfs(int v,int par) {
	sz[v]=1;
	for(auto it:g[v]) {
		if(it.first!=par) {
			dfs(it.first,v);
			sz[v]+=sz[it.first];
			cnt[it.second]=sz[it.first]*(n-sz[it.first]);
		}
	}
}

int32_t main() {
	IOS;
	cin>>n;
	int u[n+1],v[n+1],w[n+1];
	for(int i=1; i<n; i++) {
		cin>>u[i]>>v[i]>>w[i];
		g[u[i]].push_back({v[i],i});
		g[v[i]].push_back({u[i],i});
	}
	dfs(1,0);
	double ans=0;
	for(int i=1; i<n; i++)
		ans+=w[i]*cnt[i];
	int q;
	cin>>q;
	while(q--) {
		int no,r;
		cin>>no>>r;
		ans-=(w[no]-r)*cnt[no];
		w[no]=r;
		cout<<fixed<<setprecision(12)<<6.0/n/(n-1)*ans<<endl;
	}
	return 0;
}
