x=100;

%diag(v), diag(v,1) look into this function, look into a diagonal function
v = 10*ones(x,1);
u = 2*ones(x-1,1);
% u1 = 2*ones(x-1,1);
b = 1*ones(x,1);

%initial guess
x0 = 0*ones(x,1);

%problem with matlab, not the correct matrix size
A = diag(u,1) + diag(u,-1)+diag(v);

% disp(A);

x=CGM(A,b,x0);
disp(x);

function x = CGM(A,b,x0)
    %initial v
    v = b-(A*x0);
    x=x0;
    while true 
        
        t=dot(v,b-(A*x))/dot(v,A*v);
        x=(t*v)+x;    
        %put it in the bottom to reset
        v= b-(A*x);
        
        %check if it reaches to the satifised norm
        if norm((A*x)-b,"inf") < 1*10^-9
            break;
        end
    end
end