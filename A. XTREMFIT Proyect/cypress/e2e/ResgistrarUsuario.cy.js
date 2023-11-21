describe('Registrar', () => {
  it('passes', () => {
    cy.visit('http://localhost:9091/')
      //Hacer clic en Iniciar Sesion
      cy.get('#login-linkIC').click();

       cy.get('#RegistrarLogin').click();

        cy.get('#nom').type('adrian');
        cy.wait(1000);
        cy.get('#ape').focus();
        cy.get('#ape').type('valen');
        cy.get('#ape').blur();

        cy.get('#dni').type('12345678');
        cy.get('#cel').type('123456789');
        cy.get('#dir').type('Av. Casa');
        cy.get('#user').type('adrianv');
        cy.get('#pass').type('adrianv');

        cy.get('#RegistrarLoginModal').click();
        
        // Buscar un elemento que contenga el texto especificado
        cy.contains('Confirmar').click();
        cy.contains('OK').click();

        //*User
        cy.get('#userLogin').type('adrianv');
        //*Pass
        cy.get('#passwordLogin').type('adrianv');
        //*Boton Iniciar Sesion
        cy.get('#InicioLogin').click();

  })
})