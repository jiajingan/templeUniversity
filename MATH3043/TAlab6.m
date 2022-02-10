%jacob woods
%lab code 10/18/21


%time step and mesh
h=.01;
t=0:h:1;


%value of coefficent function of y'=-(1+e^(t^2))y on time mesh
% ct=-(1+exp(t.^2));
ct=-(2+sin(t));

%initializing vectors
yforward=ones(length(t),1);
ybackward=ones(length(t),1);



%forward euler code
for i=1:length(t)-1
    
    yforward(i+1)=yforward(i)+h*ct(i)*yforward(i);
    
    
end



%backward euler code
for i=1:length(t)-1
    
    %root finding
    ytemp=yforward(i);
    for j=1:3
        ytemp=ytemp-(ytemp-ytemp*ct(i+1)*h-ybackward(i))/(1+ct(i+1)*h);
        
    end
    ybackward(i+1)=ybackward(i)+h*ct(i)*ytemp;
    
    
end
hold off
plot(t,yforward)
hold on
plot(t,ybackward)
hold on


%true solution
% plot(t,exp(-1/2*(pi)^.5*erfi(t)-t))
plot(t,-(2+sin(t)))
legend('numerical solution for FE','numerical solution for BE','true solution')