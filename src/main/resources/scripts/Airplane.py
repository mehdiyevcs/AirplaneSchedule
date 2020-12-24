air=int(input())
land=int(input())
num=int(input())
#air=8
#land=2
land2=land
#num=7
vvvv=[]
cities={}
for i in range(num):
	text = input().split()
	cities[text[0]] = int(text[1])
"""cities={'a':3,
		'b':5,
		'c':13,
		'd':4,
		'e':15,
		'k':2,
		'w':7
		}"""
#print(cities)
time=[]
t=0.0
sched={}
g=air
j=0
k=0
i=0
d=True
dd=True
resair=[]
backair=[]
vvv=[]
week={}
for i in range(air):
	sched[i]=0.0
#print(sched)
day=0
themostresult=[]
days=['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday']
listcity=list(cities.keys())
while day<7:
	ch=True
	dayend=True
	time=[]
	g=air
	j=0
	k=0
	i=0
	d=True
	dd=True
	b=0
	dic={}
	backair=[]
	#print(days[day])
	if day>7:
		break
	t=0.0
	for airnumber in range(air):
		if sched[airnumber]>24:
			sched[airnumber]=sched[airnumber]-24
		else:
			sched[airnumber]=0.0
		#print('airnumber',sched[airnumber], airnumber)
		week[airnumber]=0.0
	while k<=len(list(cities.values()))-1:
		if dayend==False:
			break
		#print(k)
		while i<land:
			#print(cities)
			val_list = list(sched.values())
			if all(des>=24 for des in val_list):
					dayend=False
					break
			if j<air:
				sched[j]=week[j]+(list(cities.values())[k])*2+0.15
				time.append(t)
				#print('time',time,sched,j)
				#print('t', week[j], sched[j])
				backair.append(sched[j])
				resair.append(j)
				dic[i]=t
				if sched[j]>=24:
					hourres=sched[j]-24
					if day==6:
						dayres='Monday'
					else:
						dayres=days[day+1]
				else:
					dayres=days[day]
					hourres=sched[j]
				#print(listcity)

				themostresult.append([j,days[day],t,dayres, hourres,i, listcity[k]])
				j+=1
				k+=1
				i+=1
				g=land-air

				key_list = list(sched.keys())
				val_list = list(sched.values())
				week[j]=min(val_list)
				t=min(val_list)
				j=key_list[val_list.index(week[j])]
				if ch==False:
						if sched[j]==0.0:
							#print("CUKA", i)
							#print(week[j],j)
							#week[j]+=0.15
							#t+=0.15
							deff=len(backair)-land
							#print('deeeeeff',time[deff],week[j],j,deff )
							if time[deff]>=week[j]:

								week[j]=time[deff]+0.15
								#print('deeeeeff',time[deff],week[j],j,deff )
								t=time[deff]+0.15
				if i>=land:
					i=0
					if ch==True:
						week[j]+=0.15
						t+=0.15
					ch=False

				else:

					key_list = list(sched.keys())
					val_list = list(sched.values())
					if min(val_list)>1.0:
						week[j]=min(val_list)
						t=min(val_list)
						#print('weekj', week[j])
						j=key_list[val_list.index(week[j])]

				if sched[j]!=0.0:
					t+=0.15

			else:
				#print(j)
				key_list = list(sched.keys())
				val_list = list(sched.values())
				week[j]=min(val_list)
				t=min(val_list)
				j=key_list[val_list.index(week[j])]
				#print("t", t,j)
				d=False
			if k>len(list(cities.values()))-1:
				k=0
				#print("vaal",val_list )
				break

		if dd==False:
			break
	day+=1
	vv=0
	vvv=[]
	for numair in range(len(backair)):
		#print('baaack',backair)
		t=backair.index(min(backair))
		backair[t]=55
		vvv.append([t,vv])
		#print(vvv)
		vv+=1
		if vv>=land:
			vv=0
	vvvv.append(vvv)
citieslist=list(cities)
#print(citieslist)
#print("schedule is:",time)

dicpic={}
g=[]
ddddd=[]
for i in vvvv:
	c=sorted(i, key=lambda x: x[0])
	for j in c:
		g.append(j[1])
for i in range(len(themostresult)):
	if themostresult[i][2]-int(themostresult[i][2])>0.59:
		themostresult[i][2]=themostresult[i][2]+1-0.6
	if themostresult[i][4]-int(themostresult[i][4])>0.59:
		themostresult[i][4]=themostresult[i][4]+1-0.6

for i in range(len(themostresult)):
	themostresult[i].append(g[i])
	ddddd.append(str(themostresult[i]).replace(',',' ').replace('[','').replace(']',''))
	print(ddddd[i])
