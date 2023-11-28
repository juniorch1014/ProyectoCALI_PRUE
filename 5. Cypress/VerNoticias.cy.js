describe('Ver Noticias', () => {
  it('passes', () => {
    cy.visit('http://localhost:9091/')
  
    //Hacer clic en Iniciar Sesion
    cy.get('#login-linkIC').click();

    //Acciones de Iniciar Sesion
    //*User
    cy.get('#userLogin').focus();
    cy.get('#userLogin').type('adrianv');
    cy.get('#userLogin').blur();
    //*Pass
    cy.get('#passwordLogin').focus();
    cy.get('#passwordLogin').type('adrianv');
    cy.get('#passwordLogin').blur();
    //*Boton Iniciar Sesion
    cy.get('#InicioLogin').click();
    cy.url().should('include', '/ingresar');

    cy.get('#btNoticias').click();
  })
})