describe('template spec', () => {
  it('passes', () => {
    cy.visit('http://localhost:9091/login')
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
 
     cy.get('#btCalendario').click();

     cy.get('tbody > :nth-child(5) > :nth-child(3)').click();

     cy.get('#btCalendario').click();

  })
})