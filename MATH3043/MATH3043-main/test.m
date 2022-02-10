x=10;
v = 10*ones(x,1);
u = 2*ones(x-1,1);
% u1 = 2*ones(x-1,1);
b = 1*ones(x,1);
A = diag(u,1) + diag(u,-1)+diag(v);


    L = tril(A,-1);
    U = triu(A,1);
    D = diag(diag(A));
    
    disp(L);
    disp(U);
    disp(D);