%time steps
h=[.2,.02,.002,.0002];

%initializing vectors
errf=0*h;
errk=0*h;
for j=1:length(h)
    
%change to 2 to see the difference in stability
t=0:h(j):1;

%value of coefficent function of y'=-(1+e^(t^2))y on time mesh
% ct=-(1+exp(t.^2));
ct=-(2+sin(t));

%initializing vectors
yforward=ones(1,length(t));
ybackward=ones(1,length(t));


for i=1:length(t)-1
    %forward euler code
    yforward(i+1)=yforward(i)+h(j)*ct(i)*yforward(i);
    %root finding method
    ytemp=yforward(i);
    for k=1:3
        ytemp=ytemp-(ytemp-ytemp*ct(i+1)*h(j)-ybackward(i))/(1+ct(i+1)*h(j));
    end
    %backward euler code
    ybackward(i+1)=ybackward(i)+h(j)*ct(i)*ytemp;
end

%error calculations
% errf(j)=norm(yforward-exp(-1/2*(pi)^.5*erfi(t)-t),inf);
% errk(j)=norm(ybackward-exp(-1/2*(pi)^.5*erfi(t)-t),inf);
errf(j)=norm(yforward-((1/exp(1))*exp(cos(t)-2*t)),inf);
errk(j)=norm(ybackward-((1/exp(1))*exp(cos(t)-2*t)),inf);

%y = (1/e)*exp^(cos(t)-2t)

hold off
loglog(h,errf)
hold on
loglog(h,errk)
legend('error for FE','error for BE')
end