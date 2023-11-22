describe('template spec', () => {
  it('passes', () => {
    cy.visit('http://localhost:9091/login')
    //Hacer clic en Iniciar Sesion
    cy.get('#login-linkIC').click();

    //Acciones de Iniciar Sesion
    //*User
    cy.get('#userLogin').focus();
    cy.get('#userLogin').type('admin');
    cy.get('#userLogin').blur();
    //*Pass
    cy.get('#passwordLogin').focus();
    cy.get('#passwordLogin').type('admin');
    cy.get('#passwordLogin').blur();
    //*Boton Iniciar Sesion
    cy.get('#InicioLogin').click();
    cy.url().should('include', '/ingresar');

    cy.get('#btPlanes').click();

    cy.get('#verPlanes').click();

    cy.get('.container-fluid > .btn-success').click();

    cy.get('#nom').focus();
    cy.wait(1000);
    cy.get('#nom').type('Alerta de Infarto');
    cy.get('#nom').blur();
    cy.wait(1000);

    
    cy.get('#prec').focus();
    cy.wait(1000);
    cy.get('#prec').type('120');
    cy.get('#prec').blur();
    cy.wait(1000);

    cy.get('#exampleModal > .modal-dialog > .modal-content > .modal-footer > .btn-primary').click();
    cy.get('.swal2-confirm').click();
    cy.get('.swal2-confirm').click();

  })
})