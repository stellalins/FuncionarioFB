import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IsNumberGuard } from './guards/is-number.guard';
import { NovoFuncionarioComponent } from './pages/novo-funcionario/novo-funcionario.component';
import { ListarFuncionarioComponent } from './pages/listar-funcionario/listar-funcionario.component';
import { FuncionarioComponent } from './pages/funcionario/funcionario.component';
import { EditFuncionarioComponent } from './pages/edit-funcionario/edit-funcionario.component';
import { ConfirmeExitGuard } from './guards/confirme-exit.guard';
const routes: Routes = [
  {
    path: 'novo-funcionario',
    component: NovoFuncionarioComponent,
    canDeactivate:[
      ConfirmeExitGuard
    ]
  },
  {
    path: '',
    pathMatch: 'full',
    component: ListarFuncionarioComponent
  },
  {
    path: ':idFuncionario',
    component: FuncionarioComponent,
    canActivate: [
      IsNumberGuard
    ]
  },
  {
    path: 'edit/:idFuncionario',
    component: EditFuncionarioComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FuncionarioRoutingModule { }