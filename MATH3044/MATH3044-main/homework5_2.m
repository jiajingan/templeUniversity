%Jackie Gan
%MATH 3044, homework 5.2 only backward euler with fixed point iteration
% 
format long;
%parameter
h = 0.1;
t= 0:h:1;
% disp(t)

%initializing vectors
ybackward=ones(1,length(t));

% use this to change the value of h (0.1, 0.2... etc)
x = 0.1;

% for question 1a)
% ybackward(1) = (h*-sin(x))+1;

%for question 1b)
ybackward(1) = (h*sin(x))+1;


i = 1;
while true    
%this one is 1a)
%     ybackward(i+1) = (h*-sin(ybackward(i)+x))+1;

%this one is 1b)
ybackward(i+1) = (h*sin(ybackward(i)+x))+1;
    temp = abs(ybackward(i+1)-ybackward(i));
    if temp < 1*10^-8
%         putting it 0 just to check how many iterations it took
        ybackward(i+2) = 0;
        break;
    end
    i = i+1;
end

disp(ybackward)




