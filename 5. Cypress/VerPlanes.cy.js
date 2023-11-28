describe('Ver Planes', () => {
  
  it('passes', () => {
    cy.visit('http://localhost:9091/')
  
    //Hacer clic en Iniciar Sesion
    cy.get('#login-linkIC').click();

    //Acciones de Iniciar Sesion
    //*User
    cy.get('#userLogin').focus();
    cy.get('#userLogin').type('junior');
    cy.get('#userLogin').blur();
    //*Pass
    cy.get('#passwordLogin').focus();
    cy.get('#passwordLogin').type('junior');
    cy.get('#passwordLogin').blur();
    //*Boton Iniciar Sesion
    cy.get('#InicioLogin').click();
    cy.url().should('include', '/ingresar');

    cy.get('#btPlanes').click();

    cy.get('#5').click();
    cy.get('#cli').select('Julian Perez');
    cy.wait(1000);
    cy.get('#ser').select('Dias de infarto x10 - S/.150.0');
    cy.wait(1000);
    cy.get('#dur').type('3');
    cy.wait(1000);
    cy.contains('Registrar').click();
    cy.wait(1000);
    cy.contains('Confirmar').click();
    cy.wait(1000);
    cy.contains('OK').click();


  })
})